package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.testModel;

@Controller
public class Index {
    @GetMapping("/")
    public String getMethodName(Model model) {
        String fuck = "Fuck Microsoft!!";
        //String[] helloModel = {"Hello1","Hello2","Hello!! Fuck Microsoft!!"};
        ArrayList<testModel> testList = new ArrayList<testModel>();
        Random random = new Random();
        
        for(int i=1; i<=10; i++) {
            testModel test = new testModel();
            test.setTestId(i);
            test.setName(fuck);
            test.setRandomNum(random.nextInt(101));
            test.setFlg(random.nextInt(2));
            testList.add(test);
        }
        
        Stream<testModel> testStream = testList.stream()
                                        .filter(w -> w.getRandomNum() > 50)
                                        .sorted(Comparator.comparing(testModel::getRandomNum));
        //List<testModel> testStreamList = testStream.collect(Collectors.toList());
        List<testModel> testStreamList = testStream.toList();

        Stream<Integer> testStream2 = testList.stream()
                                        .sorted(Comparator.comparing(testModel::getRandomNum))
                                        .map(testModel::getRandomNum);
        List<Integer> testStreamList2 = testStream2.toList();
        
        testModel test = new testModel();
        test.setTestId(999);
        test.setName("Fuck Model");
    
        model.addAttribute("Mod", testList);
        model.addAttribute("ModStream", testStreamList);
        model.addAttribute("ModStream2", testStreamList2);
        model.addAttribute("Fuck", fuck);
        return "index";
    }
    
}
