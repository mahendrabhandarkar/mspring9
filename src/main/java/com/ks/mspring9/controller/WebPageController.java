package com.ks.mspring9.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ks.mspring9.entity.Community;
import com.ks.mspring9.entity.SubCommunity;
import com.ks.mspring9.vo.CommunityVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Controller
public class WebPageController {

    @Autowired
    EntityManager em;
    
    public static final Logger logger = LoggerFactory.getLogger(WebPageController.class);

    @GetMapping("/")
    public String index() {
        return "dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
    
    public List<Community> fetchAllCommunityWhichHasSimilarSubCommunityNameListORFetchOnDateAdded(CommunityVO communityVO) {
        logger.trace("fetchAllCommunityWhichHasSimilarSubCommunityNameList");
        Integer religionID = communityVO.getReligionId();
        logger.debug("religion ID: " + religionID);
        String cumtyName = communityVO.getCommunityName();
        Date fromDate = null;
        Date toDate = null;
        String updatedDateFrom = "2021-01-01";
        String updatedDateTo = "2021-01-05";
        if(updatedDateFrom != null) {
            try {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                fromDate = (Date)formatter.parse(updatedDateFrom);
            }catch(ParseException ep) {
                logger.error("ParseException:::"+ep.getMessage());
            }
        }
        if(updatedDateTo != null) {
            try {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                toDate = (Date)formatter.parse(updatedDateTo);
            }catch(ParseException ep) {
                logger.error("ParseException:::"+ep.getMessage());
            }
        }
        
        Map<String, String> defaultCumtyMap = new HashMap<>();  
        defaultCumtyMap.put("KLR", "Kalar");
        logger.debug("processNameToCndCodeMap is:::"+defaultCumtyMap);

        String defaultcommunityNameVal = null;
        if(defaultCumtyMap.get(cumtyName) != null)
        {
            defaultcommunityNameVal = defaultCumtyMap.get(cumtyName).toString();
        }
        
        List<Community> resultList = null;
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Community> query = cb.createQuery(Community.class);
            
            Root<Community> ddRoot = query.from(Community.class);
            
            Join<Community, SubCommunity> nJoin = ddRoot.join("subCommunities");
            
            Predicate predicate = cb.conjunction();
            
            if (religionID != null) {
              ParameterExpression<Long> paramReligionId = cb.parameter(Long.class, "religionId");
              predicate = cb.and(predicate, cb.equal(ddRoot.get("religionId"), paramReligionId));
            }

            if (cumtyName != null && !cumtyName.isEmpty()) {
              ParameterExpression<String> paramCumtyName = cb.parameter(String.class, "communityName");
              logger.debug("paramCumtyName   "+paramCumtyName);
              predicate = cb.and(predicate, cb.equal(nJoin.get("communityName"), paramCumtyName));
            }
            if (fromDate != null) {
                ParameterExpression<Long> paramfromDate = cb.parameter(Long.class, "createFromDate");
                logger.debug("paramfromDate   "+paramfromDate);
                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(ddRoot.get("createDate"), paramfromDate));
            }
            if (toDate != null) {
                ParameterExpression<Long> paramtoDate = cb.parameter(Long.class, "createToDate");
                logger.debug("paramtoDate   "+paramtoDate);
                predicate = cb.and(predicate, cb.lessThanOrEqualTo(ddRoot.get("createDate"), paramtoDate));
            }
            query.where(predicate);
            
            TypedQuery<Community> typedQuery = em.createQuery(query);
            if (religionID != null) {
                typedQuery.setParameter("religionId", religionID);
            }
            if (cumtyName != null && !cumtyName.isEmpty()) {
                typedQuery.setParameter("communityName", defaultcommunityNameVal);
            }
            if (fromDate != null) {
                typedQuery.setParameter("createFromDate", fromDate);
            }
            if (toDate != null) {
                typedQuery.setParameter("createToDate", toDate);
            }
            resultList = typedQuery.getResultList();
        } catch(RuntimeException ex){
            logger.error("RunTimeException Error Details: ", ex);
        }catch(Exception e) {
            logger.error("context Exception", e);
        }
        return resultList;
    }
}
