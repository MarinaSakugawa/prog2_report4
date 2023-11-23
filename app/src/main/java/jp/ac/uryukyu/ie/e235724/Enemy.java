package jp.ac.uryukyu.ie.e235724;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param _name モンスター名
     * @param _maximumHP モンスターのHP
     * @param _attack モンスターの攻撃力
     */
    public Enemy (String _name, int _maximumHP, int _attack) {
        this.setName(_name);
        this.setHitPoint(_maximumHP);
        this.setAttack(_attack);
        this.setDead(this.dead);
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", _name, _maximumHP, _attack);
    }

    /**
     * nameを設定する。
     * @param _name モンスター名
     */
    public void setName(String _name){
        this.name = _name;
    }

    /**
     * maximumHPを設定する。
     * @param _maximumHP モンスターのHP
     */
    public void setHitPoint(int _maximumHP){
        this.hitPoint = _maximumHP;
    }

    /**
     * attackを設定する。
     * @param _attack モンスターの攻撃力
     */
    public void setAttack(int _attack){
        this.attack = _attack;
    }

    /**
     * deadを設定する。
     * @param _dead モンスターの生死状態
     */
    public void setDead(boolean _dead){
        this.dead = _dead;
    }

    /**
     * nameを取得する。
     * @return this.name モンスター名
     */
    public String getName(){
        return this.name;
    }

    /**
     * hitPointを取得する。
     * @return this.hitPoint モンスターのHP
     */
    public int getHitPoint(){
        return this.hitPoint;
    }

    /**
     * attackを取得する。
     * @return this.attack モンスターの攻撃力
     */
    public int getAttack(){
        return this.attack;
    }

    /**
     * deadを取得する。
     * @return this.dead モンスターの生死状態
     */
    public boolean getDead(){
        return this.dead;
    }

    /**
     * Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        if(dead == false){
            int damage = (int)(Math.random() * this.attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.name, hero.getName(), damage);
            hero.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

}
