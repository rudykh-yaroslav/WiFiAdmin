CREATE TABLE public.report
(
    id            bigint                                 NOT NULL
        CONSTRAINT report_pkey PRIMARY KEY,
    data          TEXT                                   NOT NULL,
    created_time  TIMESTAMP WITH TIME ZONE DEFAULT now() NOT NULL,
    modified_time TIMESTAMP WITH TIME ZONE DEFAULT now() NOT NULL
);