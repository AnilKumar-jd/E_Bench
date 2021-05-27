package com.ebench.userservice.service;

import com.ebench.userservice.constants.APIMessage;
import com.ebench.userservice.dto.request.CandidateRegReqDTO;
import com.ebench.userservice.dto.response.CommonResDTO;
import com.ebench.userservice.entity.Candidate;
import com.ebench.userservice.entity.User;
import com.ebench.userservice.exceptionHandler.DefaultException;
import com.ebench.userservice.exceptionHandler.ResourceNotFoundException;
import com.ebench.userservice.repository.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class SignUpService {

    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    UserService userService;

    public CommonResDTO register(CandidateRegReqDTO dto) {
        Candidate candidate = getCandidateByUserId(dto.getUserId());
        CommonResDTO commonResDTO= new CommonResDTO();
        try {
            if (candidate !=null)
            candidate.setOverview(dto.getOverview());
            candidate.setDesignation(dto.getDesignation());
            candidate.setTopSkills(dto.getTopSkills());
            candidate.setResumeUrl(dto.getResumeUrl());
            candidate.setSkypeId(dto.getSkypeId());
            candidate.setWhatsAppNumber(dto.getWhatsAppNumber());
            candidate.setCountry(dto.getCountry());
            candidate.setState(dto.getState());
            candidate.setCity(dto.getCity());
            candidate.setPincode(dto.getPincode());
            candidate.setHobby(dto.getHobby());
            candidate.setInterest(dto.getInterest());
            candidate.setTwitterId(dto.getTwitterId());
            candidate.setLinkdId(dto.getLinkdId());
            candidateRepository.save(candidate);
            commonResDTO.setSuccess(APIMessage.SUBMIT_DETAIL);
            return commonResDTO;
        } catch (Exception e) {
            throw new DefaultException(APIMessage.SOMETHING_ELSE_ERROR);
        }
    }

    // get candidate by id.....
    public Candidate getCandidateByUserId(Long userId) {
        Candidate candidate = new Candidate();
        try {
            Optional<Candidate> cand = candidateRepository.findById(userId);
            if (cand.isPresent()) {
                candidate = cand.get();
            } else {
                throw new ResourceNotFoundException(APIMessage.USER_NOT_FOUND);
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException(APIMessage.USER_NOT_FOUND);
            //  throw  new DefaultException(APIMessage.SOMETHING_ELSE_ERROR);
        }
        return candidate;
    }

}
