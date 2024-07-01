package com.ks.mspring9.service;

import com.ks.mspring9.entity.RbacAccessMvcAccessType;
import com.ks.mspring9.entity.RbacAccessMvcAction;
import com.ks.mspring9.entity.RbacAccessMvcActionRole;
import com.ks.mspring9.entity.RbacAccessRole;
import com.ks.mspring9.repository.RbacAccessMvcActionRepository;
import com.ks.mspring9.repository.RbacAccessMvcActionRoleRepository;
import com.ks.mspring9.repository.RbacAccessRoleRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import java.util.*;

@Component
@Transactional
@Service
public class RbacRoleBasedAccessSpecifierService {

    RbacAccessMvcActionRoleRepository rbacAccessMvcActionRoleRepository;

    RbacAccessMvcActionRepository rbacAccessMvcActionRepository;

    RbacAccessRoleRepository rbacAccessRoleRepository;

    private List<RbacAccessRole> rbacAccessRoleList;

    private List<RbacAccessMvcActionRole> rbacAccessMvcActionRoleList;

    @PostConstruct
    public void load() {
//        rbacAccessRoleList = Collections.unmodifiableList(rbacAccessRoleRepository.findAll());
//        System.out.println("Roles: " + rbacAccessRoleList);
    }
/*
    public ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry addRoleBasedAccess(
            ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry addMatchers
    ) {
        Map<RbacAccessMvcAction, List<RbacAccessMvcActionRole>> accessRolesMapVal = createAccessMap();
        Set<Map.Entry<RbacAccessMvcAction, List<RbacAccessMvcActionRole>>> actionRolesEntries = accessRolesMapVal.entrySet();
        String actionName;
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry addedMatchers = null;
        for(Map.Entry<RbacAccessMvcAction, List<RbacAccessMvcActionRole>> rbacAccessMvcActionListEntry: actionRolesEntries) {
            List<RbacAccessMvcActionRole> actionRoleList = rbacAccessMvcActionListEntry.getValue();
            RbacAccessMvcAction action = rbacAccessMvcActionListEntry.getKey();

            String controllerActionUrl = action.getUrl();
            List<String> roles = new ArrayList<String>();
            LinkedMultiValueMap<RbacAccessMvcAccessType, String> methodRolesMap = new LinkedMultiValueMap<RbacAccessMvcAccessType, String>();

            for(RbacAccessMvcActionRole actionRole: rbacAccessMvcActionListEntry.getValue()) {
                System.out.println("ActionRole: " + actionRole);
                RbacAccessMvcAccessType rbacAccessMvcAccessType = actionRole.getRbacAccessMvcAccessType();
                String roleShortName = actionRole.getRbacAccessRole().getName();

                roles.add(roleShortName);
                methodRolesMap.add(rbacAccessMvcAccessType, roleShortName);
            }
           Set<Map.Entry<RbacAccessMvcAccessType, List<String>>> mres = methodRolesMap.entrySet();
            for(Map.Entry<RbacAccessMvcAccessType, List<String>> mre : mres) {
                actionName = mre.getKey().getName();
                String[] rolesArray = (String[]) mre.getValue().toArray(new String[0]);
                System.out.println("rolesArray: " + Arrays.toString(rolesArray));
                System.out.println("Action Name: " + actionName);

                switch(actionName) {
                    case "ALL":
                        addedMatchers = addMatchers.requestMatchers(controllerActionUrl).hasAnyAuthority(rolesArray);
                        break;
                    case "Read":
                    case "Write":
                    case "Update":
                    case "Remove":
                        addedMatchers = addMatchers.requestMatchers(mre.getKey().getHttpMethod(), controllerActionUrl).hasAnyAuthority(rolesArray);
                        break;
                    default:
                        break;
                }
            }
        }
        return addedMatchers;
    }
*/
    private Map<RbacAccessMvcAction, List<RbacAccessMvcActionRole>> createAccessMap() {
        Map<RbacAccessMvcAction, List<RbacAccessMvcActionRole>> map =
                new HashMap<RbacAccessMvcAction, List<RbacAccessMvcActionRole>>();

        rbacAccessMvcActionRoleList = Collections.unmodifiableList(rbacAccessMvcActionRoleRepository.findAll());

        for(RbacAccessMvcActionRole actionRole: rbacAccessMvcActionRoleList) {
            RbacAccessMvcAction action = actionRole.getRbacAccessMvcAction();
            if(!map.containsKey(action)) {
                map.put(action, new ArrayList<RbacAccessMvcActionRole>());
            }
            map.get(action).add(actionRole);
        }
        return map;
    }
}
