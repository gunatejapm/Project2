package sa.com.stc.demo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sa.com.stc.demo1.adapter.outbound.Repository1;
import sa.com.stc.demo1.config.Subject;

import java.util.List;
@Service
public class Service1 {
    @Autowired
    public Repository1 repo;
    public Subject displayById(String id) {
        return repo.displayById(id);
    }
    public List<Subject> display() {
        return repo.display();
    }
    public String add(Subject sub) {
        return repo.add(sub);
    }
    public String update(Subject sub,String id) {
        return repo.update(sub,id);
    }
    public String delete(String id) {

        return repo.delete(id);
    }
}
