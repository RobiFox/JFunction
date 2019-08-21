package me.robifoxx.jfunction.commands.execute;

import me.robifoxx.jfunction.commands.ICommand;
import me.robifoxx.jfunction.commands.StringCommand;
import me.robifoxx.jfunction.location.ILocation;
import me.robifoxx.jfunction.selectors.Selector;

import java.util.ArrayList;
import java.util.List;

/**
 * Bad code, will be rewritten.
 */
public class ExecuteCommand extends StringCommand {
    private ExecuteCommand(String cmd) {
        super(cmd);
    }

    public enum AlignAxes {
        X, Y, Z, XY, XZ, YZ;
    }

    public enum Anchor {
        EYES, FEET;
    }

    public enum Dimension {
        OVERWORLD, THE_END, THE_NETHER;
    }

    public enum Store {
        RESULT, SUCCESS;
    }

    public enum StoreType {
        BYTE, DOUBLE, FLOAT, INT, LONG, SHORT;
    }

    public enum BossBar {
        VALUE, MAX;
    }

    public enum BlocksCheck {
        ALL, MASKED;
    }

    public static class Builder {
        private List<String> with;
        public Builder() {
            with = new ArrayList<>();
        }

        public Builder withAs(Selector s) {
            with.add("as " + s.toString());
            return this;
        }

        public Builder withAt(Selector s) {
            with.add("at " + s.toString());
            return this;
        }

        public Builder withAlign(AlignAxes aa) {
            with.add("align " + aa.toString().toLowerCase());
            return this;
        }

        public Builder withAnchor(Anchor a) {
            with.add("anchor " + a.toString().toLowerCase());
            return this;
        }

        public Builder withFacing(ILocation location) {
            with.add("facing " + location.toString());
            return this;
        }

        public Builder withFacing(Selector selector, Anchor a) {
            with.add("facing entity " + selector.toString() + " " + a.toString().toLowerCase());
            return this;
        }

        public Builder withIn(Dimension d) {
            with.add("in " + d.toString().toLowerCase());
            return this;
        }

        public Builder withPositioned(ILocation location) {
            with.add("positioned " + location.toString());
            return this;
        }

        public Builder withPositioned(Selector selector, Anchor a) {
            with.add("positioned as " + selector.toString() + " " + a.toString().toLowerCase());
            return this;
        }

        public Builder withRotated(ILocation location) {
            with.add("rotated " + location.toString());
            return this;
        }

        public Builder withRotated(Selector selector, Anchor a) {
            with.add("rotated as " + selector.toString() + " " + a.toString().toLowerCase());
            return this;
        }

        public Builder withStoreEntity(Store result, Selector s, String path, StoreType st) {
            with.add("store " + result.toString().toLowerCase() + " entity " + s.toString() + " " + path + " " + st.toString());
            return this;
        }

        public Builder withStoreBossBar(Store result, BossBar value, String id, String path, StoreType st) {
            with.add("store " + result.toString().toLowerCase() + " bossbar " + id + " " + value.toString().toLowerCase() + " " + path + " " + st.toString());
            return this;
        }

        public Builder withStoreBlock(Store result, ILocation location, String path, StoreType st) {
            with.add("store " + result.toString().toLowerCase() + " block " + location.toString() + " " + path + " " + st.toString());
            return this;
        }

        public Builder withStoreScore(Store result, String objective, String name, String path, StoreType st) {
            with.add("store " + result.toString().toLowerCase() + " score " + name + " " + objective + " " + path + " " + st.toString());
            return this;
        }

        public Builder withStoreScore(Store result, String objective, Selector s, String path, StoreType st) {
            with.add("store " + result.toString().toLowerCase() + " score " + s.toString() + " " + objective + " " + path + " " + st.toString());
            return this;
        }

        public Builder withStatement(Statement statement) {
            with.add(statement.toString());
            return this;
        }

        public Builder withIf(Statement statement) {
            with.add(statement.setNegated(false).toString());
            return this;
        }

        public Builder withUnless(Statement statement) {
            with.add(statement.setNegated(true).toString());
            return this;
        }

        public ExecuteCommand withRun(ICommand cmd) {
            return new ExecuteCommand("execute " + String.join(" ", with) + " run " + cmd.toString());
        }

        public ExecuteCommand build(ICommand cmd) {
            return withRun(cmd);
        }
    }
}
