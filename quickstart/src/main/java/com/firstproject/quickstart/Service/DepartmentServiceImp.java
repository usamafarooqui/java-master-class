package com.firstproject.quickstart.Service;

import com.firstproject.quickstart.Repository.DepartmentRepository;
import com.firstproject.quickstart.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService
{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList(){ return departmentRepository.findAll();}

    public Optional<Department> getDepartmentById(Long departmentId){ return departmentRepository.findById(departmentId);}

    @Override
    public void deleteDepartmentById(Long departmentId){ departmentRepository.deleteById(departmentId);}

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department existingDepartment = departmentRepository.findById(departmentId).orElse(null);
        if (existingDepartment != null) {
            // Update the existing department with the new values, checking for nulls
            if (department.getDepartmentName() != null) {
                existingDepartment.setDepartmentName(department.getDepartmentName());
            }
            if (department.getDepartmentAddress() != null) {
                existingDepartment.setDepartmentAddress(department.getDepartmentAddress());
            }
            if (department.getDepartmentCode() != null) {
                existingDepartment.setDepartmentCode(department.getDepartmentCode());
            }
            // Add checks for other fields you want to update

            // Save the updated department
            return departmentRepository.save(existingDepartment);
        } else {
            // Handle the case where the department with given ID is not found
            return null;
        }
    }


    @Override
    public Department findByName(String name){
        return  departmentRepository.findByDepartmentName(name);
    }

}
