package t05_InterfacesAndAbstraction.p10_MooD3;

public abstract class BaseHero<T> implements Hero {
    private String username;
    private String hashedPassword;
    private int level;

    protected BaseHero(String username, int level) {
        this.username = username;
        this.level = level;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getHashedPassword() {
        return this.hashedPassword;
    }


    @Override
    public int getLevel() {
        return this.level;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s%n"
                , this.username
                , this.hashedPassword
                , this.getClass().getSimpleName());
    }
}
