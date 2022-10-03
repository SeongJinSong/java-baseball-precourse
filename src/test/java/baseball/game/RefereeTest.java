package baseball.game;

import baseball.model.BaseBallNumber;
import baseball.model.Referee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    @Test
    @DisplayName("심판이 판단을 정상적으로 하는지 테스트")
    void judge() {
        BaseBallNumber playerBaseBallNumber;
        Referee judge;
        BaseBallNumber computerBaseBallNumber = new BaseBallNumber("425");

        playerBaseBallNumber = new BaseBallNumber("123");
        judge = new Referee(computerBaseBallNumber, playerBaseBallNumber).judge();
        assertThat(judge.getBallCount()).isEqualTo(0);
        assertThat(judge.getStrikeCount()).isEqualTo(1);

        playerBaseBallNumber = new BaseBallNumber("456");
        judge = new Referee(computerBaseBallNumber, playerBaseBallNumber).judge();
        assertThat(judge.getBallCount()).isEqualTo(1);
        assertThat(judge.getStrikeCount()).isEqualTo(1);

        playerBaseBallNumber = new BaseBallNumber("789");
        judge = new Referee(computerBaseBallNumber, playerBaseBallNumber).judge();
        assertThat(judge.getBallCount()).isEqualTo(0);
        assertThat(judge.getStrikeCount()).isEqualTo(0);

        BaseBallNumber computerBaseBallNumber2 = new BaseBallNumber("713");
        playerBaseBallNumber = new BaseBallNumber("123");
        judge = new Referee(computerBaseBallNumber2, playerBaseBallNumber).judge();
        assertThat(judge.getBallCount()).isEqualTo(1);
        assertThat(judge.getStrikeCount()).isEqualTo(1);

        playerBaseBallNumber = new BaseBallNumber("145");
        judge = new Referee(computerBaseBallNumber2, playerBaseBallNumber).judge();
        assertThat(judge.getBallCount()).isEqualTo(1);
        assertThat(judge.getStrikeCount()).isEqualTo(0);

        playerBaseBallNumber = new BaseBallNumber("671");
        judge = new Referee(computerBaseBallNumber2, playerBaseBallNumber).judge();
        assertThat(judge.getBallCount()).isEqualTo(2);
        assertThat(judge.getStrikeCount()).isEqualTo(0);

        playerBaseBallNumber = new BaseBallNumber("216");
        judge = new Referee(computerBaseBallNumber2, playerBaseBallNumber).judge();
        assertThat(judge.getBallCount()).isEqualTo(0);
        assertThat(judge.getStrikeCount()).isEqualTo(1);

        playerBaseBallNumber = new BaseBallNumber("713");
        judge = new Referee(computerBaseBallNumber2, playerBaseBallNumber).judge();
        assertThat(judge.getBallCount()).isEqualTo(0);
        assertThat(judge.getStrikeCount()).isEqualTo(3);
    }
}