package com.hibernate.mapping.manytomanymapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class ManyToManyMappingProject {
    @Id
    private int projectId;
    private String projectDesc;


    @ManyToMany
    private List<ManyToManyMappingEmployee> employeeList;

    public ManyToManyMappingProject() {
    }

    public ManyToManyMappingProject(int projectId, String projectDesc, List<ManyToManyMappingEmployee> employeeList) {
        this.projectId = projectId;
        this.projectDesc = projectDesc;
        this.employeeList = employeeList;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public List<ManyToManyMappingEmployee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<ManyToManyMappingEmployee> employeeList) {
        this.employeeList = employeeList;
    }
}
