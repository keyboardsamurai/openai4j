package dev.ai4j.openai4j.completion;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Collections.unmodifiableList;
import static java.util.Collections.unmodifiableMap;

public final class Logprobs {

    private final List<String> tokens;
    private final List<Double> tokenLogprobs;
    private final List<Map<String, Double>> topLogprobs;
    private final List<Integer> textOffset;

    private Logprobs(Builder builder) {
        this.tokens = builder.tokens;
        this.tokenLogprobs = builder.tokenLogprobs;
        this.topLogprobs = builder.topLogprobs;
        this.textOffset = builder.textOffset;
    }

    public List<String> tokens() {
        return tokens;
    }

    public List<Double> tokenLogprobs() {
        return tokenLogprobs;
    }

    public List<Map<String, Double>> topLogprobs() {
        return topLogprobs;
    }

    public List<Integer> textOffset() {
        return textOffset;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof Logprobs
                && equalTo((Logprobs) another);
    }

    private boolean equalTo(Logprobs another) {
        return tokens.equals(another.tokens)
                && tokenLogprobs.equals(another.tokenLogprobs)
                && topLogprobs.equals(another.topLogprobs)
                && textOffset.equals(another.textOffset);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + tokens.hashCode();
        h += (h << 5) + tokenLogprobs.hashCode();
        h += (h << 5) + topLogprobs.hashCode();
        h += (h << 5) + textOffset.hashCode();
        return h;
    }

    @Override
    public String toString() {
        return "Logprobs{"
                + "tokens=" + tokens
                + ", tokenLogprobs=" + tokenLogprobs
                + ", topLogprobs=" + topLogprobs
                + ", textOffset=" + textOffset
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private List<String> tokens;
        private List<Double> tokenLogprobs;
        private List<Map<String, Double>> topLogprobs;
        private List<Integer> textOffset;

        private Builder() {
        }

        public Builder tokens(List<String> tokens) {
            if (tokens == null) {
                return this;
            }
            this.tokens = unmodifiableList(tokens);
            return this;
        }

        public Builder tokenLogprobs(List<Double> tokenLogprobs) {
            if (tokenLogprobs == null) {
                return this;
            }
            this.tokenLogprobs = unmodifiableList(tokenLogprobs);
            return this;
        }

        public Builder topLogprobs(List<Map<String, Double>> topLogprobs) {
            if (topLogprobs == null) {
                return this;
            }
            List<Map<String, Double>> topLogprobsCopy = new ArrayList<>();
            for (Map<String, Double> map : topLogprobs) {
                topLogprobsCopy.add(unmodifiableMap(map));
            }
            this.topLogprobs = unmodifiableList(topLogprobsCopy);
            return this;
        }

        public Builder textOffset(List<Integer> textOffset) {
            if (textOffset == null) {
                return this;
            }
            this.textOffset = unmodifiableList(textOffset);
            return this;
        }

        public Logprobs build() {
            return new Logprobs(this);
        }
    }
}