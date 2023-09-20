package com.example.buysell.services;

import com.example.buysell.models.Group;
import com.example.buysell.models.Supplier;
import com.example.buysell.repository.GroupRepository;
import com.example.buysell.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public List<Group> listGroup() {
        return groupRepository.findAll();
    }

    public Group findGroupById(Long id){
        return groupRepository.findById(id).orElse(null);
    }

    public void updateInfoGroup(Group group){
        groupRepository.save(group);
    }

    public void deleteGroup(Long id){
        groupRepository.deleteById(id);
    }

    public boolean createGroup(Group group) {
        String name = group.getName();
        if (groupRepository.findByName(name) != null) return false;
        log.info("Saving new Group with name: {}", group.getName());
        groupRepository.save(group);
        return true;
    }
}
