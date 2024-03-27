package com.firstproject.quickstart.Controller;

import com.firstproject.quickstart.Repository.DepartmentRepository;
import com.firstproject.quickstart.Service.DepartmentService;
import com.firstproject.quickstart.entity.Department;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartementController {

    @Autowired
    DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartementController.class);

    @PostMapping("/departments")
    public Department saveDepartement(@Valid @RequestBody Department department){
        LOGGER.info("Inside the post request of department");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside the get dept request of department");
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
