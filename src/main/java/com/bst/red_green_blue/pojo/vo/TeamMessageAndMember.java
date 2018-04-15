package com.bst.red_green_blue.pojo.vo;

import com.bst.red_green_blue.pojo.TeamMember;
import com.bst.red_green_blue.pojo.TeamMessage;

import java.util.ArrayList;
import java.util.List;

public class TeamMessageAndMember {

    private TeamMessage teamMessage = new TeamMessage();
    private List<TeamMember> teamMembers = new ArrayList<>();

    public TeamMessage getTeamMessage() {
        return teamMessage;
    }

    public void setTeamMessage(TeamMessage teamMessage) {
        this.teamMessage = teamMessage;
    }

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    @Override
    public String toString() {
        return "TeamMessageAndMember{" +
                "teamMessage=" + teamMessage +
                ", teamMembers=" + teamMembers +
                '}';
    }
}
