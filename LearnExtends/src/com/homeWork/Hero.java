package com.homeWork;

/**
 * @author lwf
 * @title: Hero
 * @projectName LearnExtends
 * @description: 英雄类，含公共属性
 * @date 2020/10/1018:33
 */
public class Hero {
    private String name;//名字
    private int blood;//血量
    private int attack;//攻击力
    private double spellpower;//法强
    private int MovingSpeed;//移速

    public Hero() {
    }

    public Hero(String name, int blood, int attack, double spellpower, int movingSpeed) {
        this.name = name;
        this.blood = blood;
        this.attack = attack;
        this.spellpower = spellpower;
        MovingSpeed = movingSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public double getSpellpower() {
        return spellpower;
    }

    public void setSpellpower(double spellpower) {
        this.spellpower = spellpower;
    }

    public int getMovingSpeed() {
        return MovingSpeed;
    }

    public void setMovingSpeed(int movingSpeed) {
        MovingSpeed = movingSpeed;
    }

    /**
     * 回城血量恢复到1000
     */
    public void goBack(){
        System.out.println("回城");
        blood=1000;
        System.out.println(name+"回到满血"+blood);
    }

    /**
     * 恢复200血量
     */
    public void recovery(){
        System.out.println(name+"恢复200血量,当前血量"+blood);
        if(blood<=800){
            blood+=200;
        }else{
           blood=1000;
        }
        System.out.println(name+"恢复后"+blood);
    }
}
