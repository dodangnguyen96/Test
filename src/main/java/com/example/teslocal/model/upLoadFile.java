package com.example.teslocal.model;

public class upLoadFile {
    import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

    @Data
    @AllArgsConstructor
    public class FineTuningConfig {
        @JsonProperty("model")
        private String model;
        @JsonProperty("training_file")
        private boolean trainingFile;
        @JsonProperty("batch_size")
        private int batchSize;

        @JsonProperty("classification_betas")
        private double[] classificationBetas;

        @JsonProperty("classification_n_classes")
        private int classificationNClasses;

        @JsonProperty("classification_positive_class")
        private String classificationPositiveClass;

        @JsonProperty("compute_classification_metrics")
        private boolean computeClassificationMetrics;

        @JsonProperty("learning_rate_multiplier")
        private double learningRateMultiplier;

        @JsonProperty("n_epochs")
        private int nEpochs;

        @JsonProperty("prompt_loss_weight")
        private double promptLossWeight;

        @JsonProperty("suffix")
        private String suffix;

        @JsonProperty("validation_file")
        private String validationFile;

    }

    import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

    @Data
    public class FineTuneModel {
        @JsonProperty("hyperparams")
        private Hyperparams hyperparams;

        @JsonProperty("model")
        private String model;

        @JsonProperty("training_files")
        private List<TrainingFile> trainingFiles;

        @JsonProperty("id")
        private String id;

        @JsonProperty("status")
        private String status;

        @JsonProperty("created_at")
        private long createdAt;

        @JsonProperty("updated_at")
        private long updatedAt;

        @JsonProperty("object")
        private String object;

        @Data
        public static class Hyperparams {
            @JsonProperty("compute_classification_metrics")
            private boolean computeClassificationMetrics;

            @JsonProperty("classification_n_classes")
            private int classificationNClasses;

            @JsonProperty("batch_size")
            private int batchSize;

            @JsonProperty("learning_rate_multiplier")
            private int learningRateMultiplier;

            @JsonProperty("n_epochs")
            private int nEpochs;

            @JsonProperty("prompt_loss_weight")
            private double promptLossWeight;
        }

        @Data
        public static class TrainingFile {
            @JsonProperty("statistics")
            private Statistics statistics;

            @JsonProperty("bytes")
            private int bytes;

            @JsonProperty("purpose")
            private String purpose;

            @JsonProperty("filename")
            private String filename;

            @JsonProperty("id")
            private String id;

            @JsonProperty("status")
            private String status;

            @JsonProperty("created_at")
            private long createdAt;

            @JsonProperty("updated_at")
            private long updatedAt;

            @JsonProperty("object")
            private String object;
        }

        @Data
        public static class Statistics {
            @JsonProperty("tokens")
            private int tokens;

            @JsonProperty("examples")
            private int examples;
        }
    }

}
