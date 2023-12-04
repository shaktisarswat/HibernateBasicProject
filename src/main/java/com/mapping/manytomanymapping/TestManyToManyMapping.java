package com.mapping.manytomanymapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class TestManyToManyMapping {
    public static void main(String[] args) {
        ManyToManyMappingEmployee employee = new ManyToManyMappingEmployee();
        employee.setEmployeeId(0);
        employee.setName("Shakti");

        ManyToManyMappingEmployee employee1 = new ManyToManyMappingEmployee();
        employee1.setEmployeeId(1);
        employee1.setName("Sahil");


        ManyToManyMappingEmployee employee3 = new ManyToManyMappingEmployee();
        employee3.setEmployeeId(2);
        employee3.setName("Sandeep");

        ManyToManyMappingProject project = new ManyToManyMappingProject();
        project.setProjectId(0);
        project.setProjectDesc("Library Management System ");

        ManyToManyMappingProject project1 = new ManyToManyMappingProject();
        project1.setProjectId(1);
        project1.setProjectDesc("School Management");


        List<ManyToManyMappingEmployee> employeeList = new ArrayList<>();

        employeeList.add(employee);
        employeeList.add(employee1);

        List<ManyToManyMappingEmployee> employeeList1 = new ArrayList<>();

        employeeList1.add(employee3);
        employeeList1.add(employee1);
        project.setEmployeeList(employeeList);
        project1.setEmployeeList(employeeList1);

        List<ManyToManyMappingProject> projectList = new ArrayList<>();
        projectList.add(project);
        projectList.add(project1);

        employee1.setProjectList(projectList);

        List<ManyToManyMappingProject> projectList1 = new ArrayList<>();
        projectList1.add(project);

        employee3.setProjectList(projectList1);

        List<ManyToManyMappingProject> projectList2 = new ArrayList<>();
        projectList.add(project1);

        employee.setProjectList(projectList2);

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        session.save(project1);
        session.save(project);
        session.save(employee);
        session.save(employee1);
        session.save(employee3);

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
