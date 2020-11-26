package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

public class StateMachineDefinitionBuilderImpl
        implements StateMachineDefinitionBuilder<BookStatus, BookEvent> {

    private final StateMachineDefinition<BookStatus, BookEvent> definition;
    private final StateMachineState<BookStatus, BookEvent> state;

    public StateMachineDefinitionBuilderImpl() {
        this.definition = new StateMachineDefinitionImpl();
        this.state = new StateMachineStateImpl();
    }

    @Override
    public StateMachineDefinition<BookStatus, BookEvent> build() {
        return definition;
    }

    @Override
    public StateMachineDefinitionBuilder<BookStatus, BookEvent> addState(BookStatus from,
                                                                         BookStatus to,
                                                                         BookEvent on,
                                                                         String method) {
        state.setFrom(from);
        state.setTo(to);
        state.setOn(on);
        state.setMethodToCall(method);
        definition.addState(state);
        return this;
    }

    @Override
    public StateMachineDefinitionBuilder<BookStatus, BookEvent> addState(BookStatus from,
                                                                         BookStatus to,
                                                                         BookEvent on) {
        state.setFrom(from);
        state.setTo(to);
        state.setOn(on);
        definition.addState(state);
        return this;
    }
}
