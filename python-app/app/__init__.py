from fastapi import FastAPI
from app.instrumentation import tracing
from opentelemetry.instrumentation.fastapi import FastAPIInstrumentor

tracing.setup_tracing()

app = FastAPI()

FastAPIInstrumentor.instrument_app(app)

@app.get("/")
async def root():
    return {"message": "Hello World"}
