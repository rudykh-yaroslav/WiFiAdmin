ALTER TABLE public.report
    ADD COLUMN device_details JSONB NOT NULL;

ALTER TABLE public.report
    ADD COLUMN lat FLOAT;

ALTER TABLE public.report
    ADD COLUMN lon FLOAT;

ALTER TABLE public.report
    ADD COLUMN address TEXT;
