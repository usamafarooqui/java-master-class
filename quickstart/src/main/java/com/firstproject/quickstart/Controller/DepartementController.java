package com.firstproject.quickstart.Controller;

import com.firstproject.quickstart.Repository.DepartmentRepository;
import com.firstproject.quickstart.Service.DepartmentService;
import com.firstproject.quickstart.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartementController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartement(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Optional<Department> getDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);

        return "Departmentv deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public Department  updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId , department);
    }

    @GetMapping("/departments/name/{name}")
    public Department findByName(@PathVariable("name") String name){
        return departmentService.findByName(name);
    }

}
