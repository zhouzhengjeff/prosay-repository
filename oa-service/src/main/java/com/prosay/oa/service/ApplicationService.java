package com.prosay.oa.service;

import com.prosay.oa.domain.Application;
import com.prosay.oa.domain.User;

import java.util.List;

public interface ApplicationService {

    void submitApplication(Application application);

    List<Application> findApplicationListByCurrentLoginedUser(User user);
}
