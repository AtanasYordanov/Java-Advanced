package t05_InterfacesAndAbstraction.p08_MilitaryElite.model.Impl;

import t05_InterfacesAndAbstraction.p08_MilitaryElite.constants.Missions;
import t05_InterfacesAndAbstraction.p08_MilitaryElite.model.api.IMission;

public class Mission implements IMission {
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        this.state = Missions.FINISHED_STATE;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s"
                , this.codeName, this.state);
    }
}
