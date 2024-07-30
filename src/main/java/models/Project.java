package models;

import enums.Color;
import enums.View;

public class Project {
    String projectName;
    Color color;
    String access;
    String parent;
    String favorite;
    View view;

    public Project(String projectName, Color color, String access, String parent, String favorite, View view) {
        this.projectName = projectName;
        this.color = color;
        this.access = access;
        this.parent = parent;
        this.favorite = favorite;
        this.view = view;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
