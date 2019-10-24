ALTER TABLE public.report
DROP COLUMN data;

ALTER TABLE public.report
ADD COLUMN data JSONB;