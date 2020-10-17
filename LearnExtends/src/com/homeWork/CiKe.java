package com.homeWork;

/**
 * @author lwf
 * @title: CiKe
 * @projectName LearnExtends
 * @description: TODO
 * @date 2020/10/1019:19
 */
public class CiKe extends Hero implements Skill {
    //1，2，3技能伤害
    private int one;
    private int two;
    private int three;
    public CiKe() {
    }

    public CiKe(String name, int blood, int attack, double spellpower, int movingSpeed, int one, int two, int three) {
        super(name, blood, attack, spellpower, movingSpeed);
        this.one = one;
        this.two = two;
        this.three = three;
    }

    @Override
    /**
     * 法术攻击某个英雄
     * @param beKill  被攻击对象
     * @return  被攻击对象攻击后血量
     */
    public int attack(Hero beKill){
        beKill.setBlood(beKill.getBlood()-this.getAttack());
        System.out.println(this.getName()+"对"+beKill.getName()+"造成"+this.getAttack()+"点攻击");
        return beKill.getBlood();
    }

    @Override
    public void skill1(Hero beKill) {
        beKill.setBlood(beKill.getBlood()-this.one);
        System.out.println(this.getName()+"一技能对"+beKill.getName()+"造成"+this.one+"点攻击");
        System.out.println(beKill.getName()+"还有血量"+beKill.getBlood());
    }

    @Override
    public void skill2(Hero beKill) {
        beKill.setBlood(beKill.getBlood()-this.two);
        System.out.println(this.getName()+"二技能对"+beKill.getName()+"造成"+this.two+"点攻击");
        System.out.println(beKill.getName()+"还有血量"+beKill.getBlood());
    }

    @Override
    public void skill3(Hero beKill) {
        beKill.setBlood(beKill.getBlood()-this.three);
        System.out.println(this.getName()+"二技能对"+beKill.getName()+"造成"+this.three+"点攻击");
        System.out.println(beKill.getName()+"还有血量"+beKill.getBlood());
    }


}
