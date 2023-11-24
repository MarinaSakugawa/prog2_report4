package jp.ac.uryukyu.ie.e235724;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class WarriorTest {
    /**
     * 3回ともウェポンスキルが通常攻撃の150%のダメージになっていることを検証。
     * 検証手順
     *  (1) ヒーローと敵を準備。敵のHPは10とする．
     *  (2) デモ勇者の攻撃力を100とする。ウェポンスキルは150になることを期待。
     *  (3) 攻撃前の敵のHPとウェポンスキルの攻撃力の差と、攻撃後の敵のHPが等しいはず。
     * 　　つまり3回とも敵のHP（10）ーウェポンスキル（150）＝-140であることを期待。これを検証する。
     */
    @Test
    void attackWithWeponSkillTest() {
        int attack = 100;
        Warrior demoWarrior = new Warrior("デモ勇者", 100, attack);
        Enemy slime = new Enemy("スライムもどき", 10, 100);
        int weponSkillAttack = (int)(attack * 1.5);
        int nowEnemyHp;
        for(int i = 0; i < 3; i++){
            nowEnemyHp = slime.getHitPoint();
            demoWarrior.attackWithWeponSkill(slime);
            assertEquals(nowEnemyHp - weponSkillAttack, slime.getHitPoint());
            System.out.printf("nowEnemyHp - weponSkillAttack = %s , slime.getHitPoint() = %s\n", nowEnemyHp - weponSkillAttack, slime.getHitPoint());
        }
    }    
}
