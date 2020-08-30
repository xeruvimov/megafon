package com.megafon.task.rest;

import com.megafon.task.dto.RepairRequestDTORequest;
import com.megafon.task.dto.RepairRequestDTOResponse;
import com.megafon.task.service.RepairRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/repair-request")
@Slf4j
public class RepairRequestResource {

    private final RepairRequestService repairRequestService;

    @PostMapping(value = "/create")
    @PreAuthorize("hasAuthority('admin')")
    public Long create(@RequestBody @Valid RepairRequestDTORequest repairRequest) {
        log.debug("Create new RepairRequest: {}", repairRequest);
        return repairRequestService.create(
                repairRequest.getDescription(),
                repairRequest.getAddress(),
                repairRequest.getPhoneNumber());
    }

    @GetMapping("/list")
    public List<RepairRequestDTOResponse> getAllRepairRequests() {
        log.debug("Getting all RepairRequest");
        return repairRequestService.findAll();
    }

    @PutMapping
    @PreAuthorize("hasAuthority('admin')")
    public Long update(@RequestBody @Valid RepairRequestDTOResponse repairRequest) {
        log.debug("Update RepairRequest: {}", repairRequest);
        return repairRequestService.update(repairRequest);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public void delete(@PathVariable Long id) {
        log.debug("Delete RepairRequest with id: {}", id);
        repairRequestService.delete(id);
    }
}
