package com.restapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/softwar-eengineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineer() {
        return softwareEngineerService.getAllSoftwareEngineer();
    }

    @PostMapping
    public void addSoftwareEngineer(
            @RequestBody
            SoftwareEngineer softwareEngineer
    ) {
        softwareEngineerService.addSoftwareEngineer(softwareEngineer);
    }

    @GetMapping("{id}")
    public SoftwareEngineer getSoftwareEngineerById(
            @PathVariable("id")
            Integer id
    ) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @DeleteMapping("{id}")
    public void deleteSoftwareEngineerById(
            @PathVariable("id")
            Integer id
    ) {
        softwareEngineerService.deleteSoftwareEngineerById(id);
    }

    @PutMapping("{id}")
    public SoftwareEngineer updateSoftwareEngineerById(
            @PathVariable("id")
            Integer id,
            @RequestBody
            SoftwareEngineer softwareEngineer
    ) {
        return softwareEngineerService.updateSoftwareEngineerById(id, softwareEngineer);
    }
}
