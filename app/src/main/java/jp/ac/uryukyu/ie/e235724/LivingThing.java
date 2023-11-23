package jp.ac.uryukyu.ie.e235724;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing(String _name, int _hitPoint, int _attack){
        this.setName(_name);
        this.setHitPoint(_hitPoint);
        this.setAttack(_attack);
        this.setDead(false);
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", _name, _hitPoint, _attack);
    }

    public void setName(String _name){
        this.name = _name;
    }

    public void setHitPoint(int _hitPoint){
        this.hitPoint = _hitPoint;
    }

    public void setAttack(int _attack){
        this.attack = _attack;
    }

    public void setDead(boolean _dead){
        this.dead = _dead;
    }
    
    public String getName(){
        return this.name;
    }

    public int getHitPoint(){
        return this.hitPoint;
    }

    public int getAttack(){
        return this.attack;
    }

    public boolean isDead(){
        return this.dead;
    }

    public void attack(LivingThing opponent){
        if(this.dead == false){
            int damage = (int)(Math.random() * this.attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    public void wounded(int damage){
        this.hitPoint -= damage;
        if( this.hitPoint < 0 ) {
            this.dead = true;
            System.out.printf("%sは倒れた。\n", this.name);
        }
    }
}
