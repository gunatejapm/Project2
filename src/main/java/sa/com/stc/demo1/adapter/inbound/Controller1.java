package sa.com.stc.demo1.adapter.inbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sa.com.stc.demo1.service.Service1;
import sa.com.stc.demo1.config.Subject;

import java.util.List;

@RestController
public class Controller1 {
    @Autowired
    public Service1 serv;

    @GetMapping(value="/display/{id}")
    public Subject displayById(@PathVariable("id") String id) {
        return serv.displayById(id);
    }
    @GetMapping(value="/display1")
    public List<Subject> display1() {
        return serv.display();
    }
    @RequestMapping(value="/add1",method = RequestMethod.POST)
    public String add(@RequestBody Subject sub) {
        return serv.add(sub);
    }
    @RequestMapping(value="/update1/{id}",method = RequestMethod.PUT)
    public String update(@RequestBody Subject sub,@PathVariable("id") String id) {
       return serv.update(sub,id);
    }
    @RequestMapping(value="/delete1/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String id) {
        return serv.delete(id);
    }
}
