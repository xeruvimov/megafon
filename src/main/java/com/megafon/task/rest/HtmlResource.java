package com.megafon.task.rest;

import com.megafon.task.domain.RepairRequest;
import com.megafon.task.dto.RepairRequestDTOResponse;
import com.megafon.task.service.RepairRequestService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Controller
public class HtmlResource {

    private final RepairRequestService repairRequestService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Model model) {
        List<RepairRequestDTOResponse> repairRequests = repairRequestService.findAll();

        model.addAttribute("repairRequests", repairRequests);

        return "main";
    }

    @PostMapping("/api/main")
    @PreAuthorize("hasAuthority('admin')")
    public String main(
            @RequestParam String description,
            @RequestParam String address,
            @RequestParam String phoneNumber, Map<String, Object> model) {
        repairRequestService.create(description, address, phoneNumber);

        List<RepairRequestDTOResponse> repairRequests = repairRequestService.findAll();

        model.put("repairRequests", repairRequests);

        return "main";
    }

    @GetMapping("/login")
    public String login(Map<String, Object> model) {
        return "login";
    }

    @PostMapping("/api/main-update")
    @PreAuthorize("hasAuthority('admin')")
    public String update(
            @RequestParam Long id,
            @RequestParam String description,
            @RequestParam String address,
            @RequestParam String phoneNumber, Map<String, Object> model) {
        RepairRequestDTOResponse repairRequestDTOResponse = new RepairRequestDTOResponse();

        repairRequestDTOResponse.setId(id);
        repairRequestDTOResponse.setDescription(description);
        repairRequestDTOResponse.setAddress(address);
        repairRequestDTOResponse.setPhoneNumber(phoneNumber);

        repairRequestService.update(repairRequestDTOResponse);

        model.put("repairRequests", repairRequestService.findAll());
        return "main";
    }

    @GetMapping("/api/main-delete/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public String delete(@PathVariable Long id, Map<String, Object> model) {
        repairRequestService.delete(id);

        model.put("repairRequests", repairRequestService.findAll());
        return "main";
    }

    @GetMapping("/edit/{repairRequest}")
    @PreAuthorize("hasAuthority('admin')")
    public String edit(@PathVariable RepairRequest repairRequest, Model model) {
        model.addAttribute(repairRequest);
        return "requestEdit";
    }
}
