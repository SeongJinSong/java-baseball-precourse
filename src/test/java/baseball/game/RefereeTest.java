package baseball.game;

import baseball.model.BaseBallNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    @Test
    @DisplayName("심판이 판단을 정상적으로 하는지 테스트")
    void judge() {
        BaseBallNumber playerBaseBallNumber;
        BaseBallNumber computerBaseBallNumber = new BaseBallNumber("425");
        playerBaseBallNumber = new BaseBallNumber("123");
        assertThat(new Referee(computerBaseBallNumber, playerBaseBallNumber).judge()).isEqualTo("0 1");
        playerBaseBallNumber = new BaseBallNumber("456");
        assertThat(new Referee(computerBaseBallNumber, playerBaseBallNumber).judge()).isEqualTo("1 1");
        playerBaseBallNumber = new BaseBallNumber("789");
        assertThat(new Referee(computerBaseBallNumber, playerBaseBallNumber).judge()).isEqualTo("0 0");

        BaseBallNumber computerBaseBallNumber2 = new BaseBallNumber("713");
        playerBaseBallNumber = new BaseBallNumber("123");
        assertThat(new Referee(computerBaseBallNumber2, playerBaseBallNumber).judge()).isEqualTo("1 1");
        playerBaseBallNumber = new BaseBallNumber("145");
        assertThat(new Referee(computerBaseBallNumber2, playerBaseBallNumber).judge()).isEqualTo("1 0");
        playerBaseBallNumber = new BaseBallNumber("671");
        assertThat(new Referee(computerBaseBallNumber2, playerBaseBallNumber).judge()).isEqualTo("2 0");
        playerBaseBallNumber = new BaseBallNumber("216");
        assertThat(new Referee(computerBaseBallNumber2, playerBaseBallNumber).judge()).isEqualTo("0 1");
        playerBaseBallNumber = new BaseBallNumber("713");
        assertThat(new Referee(computerBaseBallNumber2, playerBaseBallNumber).judge()).isEqualTo("0 3");
    }
}