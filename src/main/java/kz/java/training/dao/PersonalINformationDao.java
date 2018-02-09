package kz.java.training.dao;

import kz.java.training.entity.PersonalInformation;

public interface PersonalINformationDao extends AbstractDao<PersonalInformation> {
	
	int insertPersonalInformationWithGeneratedKey(PersonalInformation personalInformation);

}
