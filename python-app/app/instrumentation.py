import os
from opentelemetry import trace

from opentelemetry.sdk.resources import Resource
from opentelemetry.sdk.trace import TracerProvider
from opentelemetry.sdk.trace.export import BatchSpanProcessor
from opentelemetry.exporter.otlp.proto.http.trace_exporter import OTLPSpanExporter

class Tracing:
    def __init__(self):
        self.tracer_provider = None

    def setup_tracing(self):
        endpoint = os.getenv("OTEL_EXPORTER_OTLP_ENDPOINT", "http://collector:4318")

        resource = Resource(attributes={
            "service.name": "python-app"
        })

        trace.set_tracer_provider(TracerProvider(resource=resource))
        self.tracer_provider = trace.get_tracer_provider()

        otlp_exporter = OTLPSpanExporter(endpoint=endpoint)
        span_processor = BatchSpanProcessor(otlp_exporter)
        self.tracer_provider.add_span_processor(span_processor)


tracing = Tracing()
