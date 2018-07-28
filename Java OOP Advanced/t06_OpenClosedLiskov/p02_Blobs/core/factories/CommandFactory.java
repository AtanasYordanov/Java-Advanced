package t06_OpenClosedLiskov.p02_Blobs.core.factories;

import t06_OpenClosedLiskov.p02_Blobs.annotations.Inject;
import t06_OpenClosedLiskov.p02_Blobs.core.services.BlobService;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Executable;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Factory;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Writer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class CommandFactory implements Factory<Executable> {

    private static final String PATH_TO_COMMANDS = "t06_OpenClosedLiskov.p02_Blobs.core.commands.";

    private BehaviourFactory behaviourFactory;
    private AttackFactory attackFactory;
    private BlobService blobService;
    private Writer writer;

    public CommandFactory(BehaviourFactory behaviourFactory, AttackFactory attackFactory
            , BlobService blobService, Writer writer) {
        this.behaviourFactory = behaviourFactory;
        this.attackFactory = attackFactory;
        this.blobService = blobService;
        this.writer = writer;
    }

    @Override
    public Executable getInstance(String name) {
        name = name.split("-")[0];
        String commandName = Character.toUpperCase(name.charAt(0)) + name.substring(1) + "Command";
        try {
            Class<?> clazz = Class.forName(PATH_TO_COMMANDS + commandName);
            Constructor constructor = clazz.getConstructor();
            Executable executable = (Executable) constructor.newInstance();
            this.injectDependencies(executable);
            return executable;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException | InstantiationException e) {
            return null;
        }
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] commandFactoryFields = this.getClass().getDeclaredFields();
        Field[] dependencyFields = Arrays.stream(executable.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Inject.class))
                .toArray(Field[]::new);
        for (Field dependencyField : dependencyFields) {
            dependencyField.setAccessible(true);
            for (Field commandFactoryField : commandFactoryFields) {
                commandFactoryField.setAccessible(true);
                if (dependencyField.getType().equals(commandFactoryField.getType())
                        && dependencyField.getName().equals(commandFactoryField.getName())) {
                    dependencyField.set(executable, commandFactoryField.get(this));
                }
            }
        }
    }
}
