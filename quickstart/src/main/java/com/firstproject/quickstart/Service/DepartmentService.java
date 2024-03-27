package com.firstproject.quickstart.Service;

import com.firstproject.quickstart.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Optional<Department> getDepartmentById(Long departmentId);

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId , Department department);

    public Department findByName(String name);
}
