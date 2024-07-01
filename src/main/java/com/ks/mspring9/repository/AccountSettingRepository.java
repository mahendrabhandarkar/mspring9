package com.ks.mspring9.repository;

import com.ks.mspring9.entity.AccountSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountSettingRepository extends JpaRepository<AccountSetting, Integer>, JpaSpecificationExecutor<AccountSetting> {

}