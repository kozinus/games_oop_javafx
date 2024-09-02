package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    public void whenWayNotDiagonal()
            throws ImpossibleMoveException {
        Figure bishop = new BishopBlack(Cell.A8);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            bishop.way(Cell.A1);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from A8 to A1");

    }

    @Test
    public void whenWayIsDiagonal()
            throws ImpossibleMoveException {
        Figure bishop = new BishopBlack(Cell.A8);
        assertThat(bishop.way(Cell.H1))
                .isEqualTo(new Cell[]
                        {Cell.B7, Cell.C6, Cell.D5, Cell.E4, Cell.F3, Cell.G2, Cell.H1});
    }
}