package com.example.buysell.services;

import com.example.buysell.models.Group;
import com.example.buysell.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public List<Group> listGroups() {
        return  groupRepository.findAll();
    }
}
