package com.megafon.task.service;

import com.megafon.task.domain.RepairRequest;
import com.megafon.task.dto.RepairRequestDTORequest;
import com.megafon.task.dto.RepairRequestDTOResponse;
import com.megafon.task.mapper.RepairRequestMapper;
import com.megafon.task.repository.RepairRequestRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RepairRequestService {

    private final RepairRequestRepository repairRequestRepository;
    private final RepairRequestMapper repairRequestMapper;

    @Transactional
    public RepairRequest findById(Long id) throws NotFoundException {
        return repairRequestRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("No Repair Request with id: " + id));
    }

    @Transactional
    public List<RepairRequestDTOResponse> findAll() {
        List<RepairRequest> result = repairRequestRepository.findAllByDeletedFalse();
        return repairRequestMapper.toDto(result);
    }

    @Transactional
    public Long create(String description,
                       String address,
                       String phoneNumber) {
        RepairRequest repairRequest = new RepairRequest(description, address, phoneNumber);
        return repairRequestRepository.save(repairRequest).getId();
    }

    @Transactional
    public Long update(RepairRequestDTOResponse repairRequest) {
        RepairRequest request = repairRequestRepository.findByIdAndDeletedFalse(repairRequest.getId())
                .orElseThrow(() -> new IllegalStateException("Not found RepairRequest with id: " + repairRequest.getId()));

        request.setDescription(repairRequest.getDescription());
        request.setAddress(repairRequest.getAddress());
        request.setPhoneNumber(repairRequest.getPhoneNumber());

        return repairRequestRepository.save(request).getId();
    }

    @Transactional
    public void delete(Long id) {
        repairRequestRepository.delete(id);
    }
}
