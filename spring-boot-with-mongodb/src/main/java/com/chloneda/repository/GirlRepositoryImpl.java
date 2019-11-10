package com.chloneda.repository;

import com.chloneda.model.Girl;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * @author chloneda
 * @description:
 */
public class GirlRepositoryImpl implements GirlRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     *
     * @param girl
     */
    @Override
    public void create(Girl girl) {
        mongoTemplate.save(girl);
    }

    /**
     * 根据名查询对象
     *
     * @param girlName
     * @return
     */
    @Override
    public Girl findGirlByName(String girlName) {
        Query query = new Query(Criteria.where("userName").is(girlName));
        Girl girl = mongoTemplate.findOne(query, Girl.class);
        return girl;
    }

    /**
     * 更新对象
     *
     * @param girl
     */
    @Override
    public long update(Girl girl) {
        Query query = new Query(Criteria.where("id").is(girl.getId()));
        Update update = new Update().set("name", girl.getName()).set("age", girl.getAge());
        //更新查询返回结果集的第一条
        UpdateResult result = mongoTemplate.updateFirst(query, update, Girl.class);
        if (result != null) {
            return result.getMatchedCount();
        }
        return 0;
    }

    /**
     * 删除对象
     *
     * @param id
     */
    @Override
    public void deleteGirlById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Girl.class);
    }

}
