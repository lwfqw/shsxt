package com.homeWork;

/**
 * @author lwf
 * @title: App
 * @projectName LearnExtends
 * @description: TODO
 * @date 2020/10/1019:36
 */
public class App {
    public static void main(String[] args) {
        CiKe libai=new CiKe("李白", 800, 30, 2, 12, 40, 50, 80);
        FaSi daji=new FaSi("妲己",600,2,30.0,10,30,40,50);
        //李白普通攻击妲己
        System.out.println("妲己剩余"+libai.attack(daji));
        //妲己一技能打李白
        daji.skill1(libai);
        //李白二技能打妲己
        libai.skill2(daji);
        //妲己大招打李白
        daji.skill3(libai);
        //李白回城
        libai.goBack();
        //妲己恢复血量技能
        daji.recovery();
    }
}
