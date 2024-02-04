package nextstep.ladder.service;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderInfo;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameHandler {

    private LadderGameHandler() { // 인스턴스화 방지
    }

    public static void runGame() {
        Participants participants = inputAndRegisterParticipant();
        ResultView.enter();

        Ladder ladder = drawLadder(participants);

        printLadder(participants, ladder);
    }

    private static void printLadder(Participants participants, Ladder ladder) {
        ResultView.printResultWord();
        ResultView.printParticipantsName(participants);
        ResultView.printLadder(ladder);
    }

    private static Ladder drawLadder(Participants participants) {
        int ladderHeight = InputView.inputLadderHeight();
        LadderInfo ladderInfo = new LadderInfo(ladderHeight, participants.count());
        Ladder ladder = Ladder.generate(ladderInfo);
        ResultView.enter();
        return ladder;
    }

    private static Participants inputAndRegisterParticipant() {
        String inputParticipantName = InputView.inputParticipantName();
        return new Participants(inputParticipantName);
    }
}
