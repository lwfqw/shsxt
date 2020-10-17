package com.homeWork;

/**
 * @author lwf
 * @title: Skill
 * @projectName LearnExtends
 * @description: TODO
 * @date 2020/10/1018:46
 */
public interface Skill {
    /**
     * 攻击某个英雄
     * @param beKill  被攻击对象
     * @return  被攻击对象攻击后血量
     */
    int attack(Hero beKill);

    /**
     * 一技能
     */
    void skill1(Hero beKill);
    /**
     * 二技能
     */
    void skill2(Hero beKill);
    /**
     * 三技能
     */
    void skill3(Hero beKill);
}
