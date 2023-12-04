package com.mapping.manytomanymapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class ManyToManyMappingEmployee {
    @Id
    private int employeeId;
    private String name;
    @ManyToMany(mappedBy = "employeeList")
    private List<ManyToManyMappingProject> projectList;


    public ManyToManyMappingEmployee() {
    }

    public ManyToManyMappingEmployee(int employeeId, String name, List<ManyToManyMappingProject> projectList) {
        this.employeeId = employeeId;
        this.name = name;
        this.projectList = projectList;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ManyToManyMappingProject> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ManyToManyMappingProject> projectList) {
        this.projectList = projectList;
    }

    @Override
    public String toString() {
        return "ManyToManyMappingEmployee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", projectList=" + projectList +
                '}';
    }
}
