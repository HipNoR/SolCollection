package ru.gus.dispatch;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DispatchActionsTest {
    @Test
    public void whenAddingThanAddAction() {
       assertThat(new DispatchActions().init().doAction(() -> Action.Type.ADD), is("Added"));
    }

    @Test
    public void whenUpdateThanUpdated() {
        assertThat(new DispatchActions().init().doAction(() -> Action.Type.UPDATE), is("Updated"));
    }

    @Test
    public void whenDeleteThanDeleted() {
        assertThat(new DispatchActions().init().doAction(() -> Action.Type.DELETE), is("Deleted"));
    }
}