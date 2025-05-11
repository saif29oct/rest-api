package com.restapi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineer() {
        return softwareEngineerRepository.findAll();
    }

    public void addSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(id).orElseThrow(() -> new RuntimeException("Software Engineer not found"));
        System.out.println(softwareEngineer);
        return softwareEngineer;
    }

    public void deleteSoftwareEngineerById(Integer id) {
        softwareEngineerRepository.deleteById(id);
    }

    public SoftwareEngineer updateSoftwareEngineerById(Integer id, SoftwareEngineer softwareEngineer) {
        SoftwareEngineer softwareEngineer1 = softwareEngineerRepository.findById(id).orElseThrow(() -> new RuntimeException("Software Engineer not found"));
        softwareEngineer1.setName(softwareEngineer.getName());
        softwareEngineer1.setTechStack(softwareEngineer.getTechStack());
        softwareEngineerRepository.save(softwareEngineer1);
        return softwareEngineer1;
    }
}
