package com.example.buysell.controllers;

import com.example.buysell.models.Group;
import com.example.buysell.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
public class AdminGroupController {
    private final GroupService groupService;

    @GetMapping("/admin/groups")
    public String admin(Model model) {
        model.addAttribute("groups", groupService.listGroup());
        return "groups";
    }

    @GetMapping("/admin/groups/edit/{id}")
    public String groupEditForm(@PathVariable("id") Long id, Model model) {
        Group group = groupService.listGroup()
                .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("group", group);
        Integer action = 1;
        model.addAttribute("action", action);
        return "groupEditInsert";
    }

    @GetMapping("/admin/groups/insert")
    public String groupInsertForm(Model model) {
        model.addAttribute("act",2);
        Integer action = 2;
        model.addAttribute("action", action);
        return "groupEditInsert";
    }

    @PostMapping("/admin/groups/update")
    public String groupUpdate(@RequestParam("groupId") Group group, Group groupUpdateInfo) {
        group.setName(groupUpdateInfo.getName());
        groupService.updateInfoGroup(group);
        return "redirect:/admin/groups";
    }

    @PostMapping("/admin/groups/delete/{id}")
    public String groupDelete(@PathVariable Long id) {
        groupService.deleteGroup(id);
        return "redirect:/admin/groups";
    }

    @PostMapping("/admin/groups/create")
    public String createGroup(Group group, Model model) {
        if (!groupService.createGroup(group)) {
            model.addAttribute("errorMessage", "Группа с наименованием " + group.getName() + " уже существует");
            return "redirect:/admin/groups/insert";
        }
        return "redirect:/admin/groups";
    }
}
