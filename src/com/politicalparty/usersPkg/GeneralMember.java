package com.politicalparty.usersPkg;

import java.io.File;

import com.politicalparty.Party;
import com.politicalparty.util.Donation;
import com.politicalparty.util.IFundPayable;
import com.politicalparty.util.IProjectCreatable;
import com.politicalparty.util.Project;
import com.politicalparty.util.Report;

public class GeneralMember extends User implements IProjectCreatable, IFundPayable {

    private Project assignedProject;
    private int currentProjectRating, completedProjectCount;
    private float overallRating;
    private boolean isProjectReportRequested;

    public GeneralMember(String name, String nid, String location, String emailAddress, String phoneNumber, int age) {
        super(name, nid, location, emailAddress, phoneNumber, age);
        // TODO Auto-generated constructor stub
    }

    public void setCurrentProjectRating(int rating) {
        this.currentProjectRating = rating;
    }

    @Override
    public void createProject(String projectTitle, String projectDescription, int expenditure, File attachment,
            String location) {
        // TODO Auto-generated method stub

    }

    public boolean assignProject(Project project) {
        if (assignedProject == null) {
            assignedProject = project;
            return true;
        } else {
            return false;
        }
    }

    public void requestReport() {
        isProjectReportRequested = true;
    }

    public void sendReport(String message, File attachment) {
        if (isProjectReportRequested) {
            Party.manager.addProjectImplementationReport(assignedProject, new Report(message, attachment));
            isProjectReportRequested = false;
        } else {
            assignedProject.setReport(new Report(message, attachment));
        }
    }

    public void projectCompleted() {
        overallRating = (overallRating * completedProjectCount) + currentProjectRating;
        completedProjectCount++;
        overallRating /= completedProjectCount;
    }

    public void addProjectReport(String message, File file) {
        assignedProject.setReport(new Report(message, file));
    }

    @Override
    public void donateFund(float amount) {
        Party.finaciaManager.addFund(new Donation(amount, this));
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean isVacant() {
        return assignedProject == null;
    }

    public String getProjectTitle() {
        return assignedProject.getTitleProperty();
    }

    public Report getReport() {
        return assignedProject.getReport();
    }

    public int getCurrentRating() {
        return currentProjectRating;
    }

}
