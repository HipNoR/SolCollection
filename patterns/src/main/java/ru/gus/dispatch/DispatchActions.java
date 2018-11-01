package ru.gus.dispatch;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * DispatchPattern example.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 01.11.2018
 */
public class DispatchActions {


    private final Map<Action.Type, Function<Action, String>> dispatch = new HashMap<>();


    public Function<Action, String> add() {
        return user -> "Added";
    }

    public Function<Action, String> update() {
        return user -> "Updated";
    }

    public Function<Action, String> delete() {
        return user -> "Deleted";
    }

    public DispatchActions init() {
        this.load(Action.Type.ADD, this.add());
        this.load(Action.Type.UPDATE, this.update());
        this.load(Action.Type.DELETE, this.delete());
        return this;
    }

    public void load(Action.Type type, Function<Action, String> handle) {
        this.dispatch.put(type, handle);
    }

    public String doAction(final Action action) {
        return this.dispatch.get(action.type()).apply(action);
    }
}
