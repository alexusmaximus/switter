package com.nriker.switter.persistance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.nriker.switter.model.SwitterUser;
import org.springframework.beans.factory.annotation.Value;

@Repository
public class SwitterUserRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Value("${spring.data.mongodb.database.collection.users}")
    private String usersCollection;

	public SwitterUser addUser(SwitterUser user) {
		if (findUser(user.getName()) == null) {
			return mongoTemplate.insert(user, usersCollection);
		} else {
			System.out.println("Der User schon existiert!");
			return null;
		}
	}

	public SwitterUser findUser(String userName) {
		Query query = new Query(Criteria.where("name").is(userName));
		return mongoTemplate.findOne(query, SwitterUser.class, usersCollection);
	}

	public List<SwitterUser> findAllUser() {
		return mongoTemplate.findAll(SwitterUser.class, usersCollection);
	}

	public SwitterUser deleteUser(String userName) {
		Query query = new Query(Criteria.where("name").is(userName));
		// return mongoTemplate.remove(query, SwitterUser.class, usersCollection);
		return mongoTemplate.findAndRemove(query, SwitterUser.class, usersCollection);
	}
}
